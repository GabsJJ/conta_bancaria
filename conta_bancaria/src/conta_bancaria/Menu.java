package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int opcao;
		
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
			opcao = leia.nextInt();
			
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
				break;
			case 2:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"               Listar todas as contas                \n\n"+Cores.TEXT_RESET);
				break;
			case 3:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"         Consultar dados da conta - por número       \n\n"+Cores.TEXT_RESET);
				break;
			case 4:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"               Atualizar dados da conta              \n\n"+Cores.TEXT_RESET);
				break;
			case 5:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"                    Apagar a conta                   \n\n"+Cores.TEXT_RESET);
				break;
			case 6:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"                        Saque                        \n\n"+Cores.TEXT_RESET);
				break;
			case 7:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"                      Depósito                       \n\n"+Cores.TEXT_RESET);
				break;
			case 8:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_UNDERLINED+
						"              Transferência entre contas             \n\n"+Cores.TEXT_RESET);
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nDigite uma opção válida!\n");
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
}
