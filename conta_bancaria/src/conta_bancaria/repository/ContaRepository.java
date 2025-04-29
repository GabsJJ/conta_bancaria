package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {
	//Métodos do CRUD
	public void procurarPorNumero(int numero); //procura dados da conta por número dela
	public void listarTodas();
	public void cadastrar(Conta novaConta); //cadastrar uma nova conta
	public void atualizar(Conta novaConta);
	public void deletar(int numero);
	
	//Metodos bancarios
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);
}
