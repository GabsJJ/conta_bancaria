package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		ContaController contas = new ContaController();
		int opcao, numero, numeroDestino, agencia, tipo, aniversario;
		String titular;
		float saldo, limite, valor;
		
		//dados mock
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);
		
		while(true) {
			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_WHITE_BACKGROUND
				           	 + "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_PURPLE+Cores.ANSI_WHITE_BACKGROUND+"\nBanco do Brazil com Z - O seu Futuro começa aqui!    ");
				sobre();
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"                    Criar conta                      \n\n"+Cores.TEXT_RESET);
				
				try {
					System.out.print("Digite o número da agência: ");
					agencia = leia.nextInt();
					System.out.print("Digite o nome do titular: ");
					titular = leia.next();
					System.out.print("Digite o tipo de conta (1 - CC | 2 - CP): ");
					tipo = leia.nextInt();
					System.out.print("Digite o saldo inicial da conta: ");
					saldo = leia.nextFloat();
				} catch(InputMismatchException e) {
					System.out.println("Digite uma entrada válida!");
					leia.nextLine();
					tipo = agencia = 0;
					saldo = 0f;
					titular = "";
				}
				
				switch(tipo) {
				case 1 -> {
					System.out.print("Digite o limite da conta: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.print("Digite o dia do aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"               Listar todas as contas                \n\n"+Cores.TEXT_RESET);
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"         Consultar dados da conta - por número       \n\n"+Cores.TEXT_RESET);
				System.out.print("Digite o número da conta procurada: ");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"               Atualizar dados da conta              \n\n"+Cores.TEXT_RESET);
				

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				Optional<Conta> conta = contas.buscarNaCollection(numero);
				if(conta.isPresent()) {
					
					System.out.print("Digite o número da Agência: ");
					agencia = leia.nextInt();
					
					System.out.print("Digite o nome do Titular: ");
					leia.skip("\\R");
					titular = leia.nextLine();
					
					tipo = conta.get().getTipo();
					
					System.out.print("Digite o novo Saldo da conta: ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
						case 1 ->{
									System.out.print("Digite o limite da conta: ");
									limite = leia.nextFloat();
									contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
							}
						case 2 ->{
									System.out.print("Digite o dia do aniversário da conta: ");
									aniversario = leia.nextInt();
									contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
							}
					}
				}else
					System.out.printf("\n A conta número %d não existe!", numero);
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"                    Apagar a conta                   \n\n"+Cores.TEXT_RESET);
				
				System.out.print("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"                        Saque                        \n\n"+Cores.TEXT_RESET);
				
				System.out.print("Digite o número da conta: ");
				numero = leia.nextInt();
				
				System.out.print("Digite o valor do saque: ");
				valor = leia.nextFloat();
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"                      Depósito                       \n\n"+Cores.TEXT_RESET);
				
				System.out.print("Digite o número da conta: ");
				numero = leia.nextInt();
				
				System.out.print("Digite o valor do depósito: ");
				valor = leia.nextFloat();
				
				contas.depositar(numero, valor);
				keyPress();
				break;
			case 8:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"              Transferência entre contas             \n\n"+Cores.TEXT_RESET);
				
				System.out.println("Digite o número da conta de origem: ");
				numero = leia.nextInt();
				
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = leia.nextInt();
				
				System.out.println("Digite o valor do depósito: ");
				valor = leia.nextFloat();
				
				contas.transferir(numero, numeroDestino, valor);
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nDigite uma opção válida!\n");
				keyPress();
				break;
			}
		}
	}
	
	public static void sobre() {
		System.out.println("\n*****************************************************");
		System.out.println("Projeto Desenvolvido por: Gabriel Julio              ");
		System.out.println("Generation Brasil - gabrielj@genstudents.org         ");
		System.out.println("github.com/GabsJJ                                    ");
		System.out.println("*****************************************************");
	}
	
	public static void keyPress() {
		try {
	        System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
	        
	        // Lê apenas a tecla Enter e ignora outras teclas
	        int input;
	        while ((input = System.in.read()) != '\n') {
	            // Ignora qualquer outra tecla diferente do Enter
	            if (input == -1) {
	                throw new IOException("Entrada encerrada inesperadamente");
	            }
	        }
	        
	    } catch (IOException e) {
	        System.err.println("Erro de entrada/saída: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
	    }
	}
}
