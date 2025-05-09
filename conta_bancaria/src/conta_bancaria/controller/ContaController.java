package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;
import conta_bancaria.util.Cores;

public class ContaController implements ContaRepository {
	//o obj contaController, na aplicação, vai funcionar como uma entidade central para gerenciar as contas do banco
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>(); //funciona como o banco de dados, nesse caso
	int numero = 0; //controla o número das contas
	
	@Override
	public void procurarPorNumero(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			conta.get().visualizar();
		else
			System.out.printf("\nA conta número %d não foi encontrada", numero);
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta novaConta) {
		try {
			listaContas.add(novaConta);
			System.out.println(Cores.TEXT_GREEN+"A conta foi criada com sucesso!");
		} catch(Exception e) {
			System.out.println(Cores.TEXT_RED_BRIGHT+"Não foi possível criar a conta. Verifique os dados e tente novamente!");
		}
	}

	@Override
	public void atualizar(Conta novaConta) {
		Optional<Conta> buscaConta = buscarNaCollection(novaConta.getNumero());
		
		if(buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), novaConta);
			System.out.printf("\nA Conta número %d foi atualizada com sucesso!", novaConta.getNumero());
		} else
			System.out.printf("\nA Conta número %d não foi encontrada", novaConta.getNumero());
		
	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		if(conta.isPresent()) {
			if(listaContas.remove(conta.get()) == true) {
				System.out.printf("\nA Conta número %d foi excluída com sucesso!", numero);
			} else 
				System.out.printf("\nA Conta número %d não foi encontrada", numero);
		}
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	//Métodos auxiliares
	public int gerarNumero() { //gera o número da conta automaticamente, funciona como um atualizador de state global
		return ++numero;
	}
	
	//deixei como private pois esse método apenas auxilia o procurarPorNumero, que é o que deve ser utilizado principalmente
	private Optional<Conta> buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero)
				return Optional.of(conta);
		}
		return Optional.empty();
	}
}
