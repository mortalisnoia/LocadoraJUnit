package local.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import local.exception.ClienteException;
import local.exception.FilmeSemEstoqueException;
import local.exception.LocadoraException;
import local.service.LocacaoService;

public class ClienteTest {
	// TODO: O nome não pode ser nulo. Lança RuntimeException - Nome é um campo
	// obrigatório

	@Test
	public void naoDeveLocarFilmeComUsuarioSemNome() {
		// Cenário
		Cliente cliente = new Cliente();

		ArrayList<Filme> filmeArray = new ArrayList<Filme>();
		Filme filme = new Filme();

		filme.setNome("Oloco Meu");
		filme.setEstoque(2);
		filme.setPrecoLocacao(4.00);

		filmeArray.add(filme);

		LocacaoService ls = new LocacaoService();

		// Processamento e validação
		try {
			// TODO: Corrigir parâmetro para teste
			cliente.setNome(null);
			fail("Não pode locar com usuário sem nome");

		} catch (ClienteException ex) {
			assertThat(ex.getMessage(), equalTo("Nome é um campo obrigatório"));
		}
	}

	// TODO: nome deve possuir entre 4 e 55 caracteres (inclusive). Lança
	// ClienteException - O nome do cliente deve possuir entre 4 e 55 caracteres

	@Test
	public void deveLocarFilmeSeNomeUsuarioFor55() {
		// Cenário
		Cliente cliente = new Cliente();
		String nome = "";
		for (int i = 0; i < 53; i++) {
			nome += "a";
		}
		nome += " a";

		// Processamento e validação
		try {
			// TODO: Corrigir parâmetro para teste
			cliente.setNome(nome);
			// fail("Locação realizada com usuário null");
		} catch (FilmeSemEstoqueException | ClienteException ex) {
			fail("O nome do usuário não pode ser desse tamanho");
		}
	}

	@Test
	public void NaoDeveLocarFilmeSeNomeUsuarioForMaiorQue55() {
		// Cenário
		Cliente cliente = new Cliente();
		String nome = "";
		for (int i = 0; i < 56; i++) {
			nome += "a";
		}

		// Processamento e validação
		try {
			// TODO: Corrigir parâmetro para teste
			cliente.setNome(nome);
			fail("O nome do usuário não pode ter mais que 55 letras");
			// fail("Locação realizada com usuário null");
		} catch (FilmeSemEstoqueException | ClienteException ex) {

		}
	}

	@Test
	public void deveLocarFilmeSeNomeUsuarioFor4() {
		// Cenário
		Cliente cliente = new Cliente();
		String nome = "aa a";

		// Processamento e validação
		try {
			// TODO: Corrigir parâmetro para teste
			cliente.setNome(nome);
			// fail("Locação realizada com usuário null");
		} catch (FilmeSemEstoqueException | ClienteException ex) {
			fail("O nome do usuário não pode ser desse tamanho");
		}
	}

	@Test
	public void NaoDeveLocarFilmeSeNomeUsuarioForMenorQue4() {
		// Cenário
		Cliente cliente = new Cliente();
		String nome = "";
		for (int i = 0; i < 3; i++) {
			nome += "a";
		}

		// Processamento e validação
		try {
			// TODO: Corrigir parâmetro para teste
			cliente.setNome(nome);
			fail("O nome do usuário não pode ter menos que 4 letras");
		} catch (FilmeSemEstoqueException | ClienteException ex) {

		}
	}

	// TODO: O nome do cadastro deve possuir pelo menos 2 nomes (ex.: Angelo Luz)
	@Test
	public void clienteNomeDeveTer2Nomes() {
		Cliente cliente = new Cliente();
		String nome = "Michel Luz";

		// Processamento e validação
		try {
			// TODO: Corrigir parâmetro para teste
			cliente.setNome(nome);

		} catch (FilmeSemEstoqueException | ClienteException ex) {
			fail("O nome do usuário deve possuir sobrenome");
		}
	}

	// TODO: O nome deverá ser salvo sem espaços no início e fim
	@Test
	public void clienteNomeNaoPodeTerEspacoInicio() {
		Cliente cliente = new Cliente();
		String nome = " Michel Luz";
		System.out.println("inicio: " + nome.charAt(0));
		System.out.println("fim: " + nome.charAt(nome.length() - 1));

		// Processamento e validação,
		try {
			// TODO: Corrigir parâmetro para teste
			cliente.setNome(nome);
			fail("Nome não pode ter espaço vazio no começo");
		} catch (FilmeSemEstoqueException | ClienteException ex) {
			assertThat(ex.getMessage(), equalTo("Nome não pode ter espaços no começo"));
		}
	}

	@Test
	public void clienteNomeNaoPodeTerEspacoFim() {
		Cliente cliente = new Cliente();
		String nome = "Michel Luz ";

		// Processamento e validação,
		try {
			// TODO: Corrigir parâmetro para teste
			cliente.setNome(nome);
			fail("Nome não pode ter espaço vazio no fim");
		} catch (FilmeSemEstoqueException | ClienteException ex) {
			assertThat(ex.getMessage(), equalTo("Nome não pode ter espaços no final"));
		}
	}

	// TODO: O nome não deverá possuir símbolo ou número.Lança ClienteException -
	// Números e símbolos não são permitidos
	@Test
    public void clienteNomeNaoDeveTerNumeros() {
    	Cliente cliente = new Cliente();
        String nome = "Michel Luz123";
        
           
    

        //Processamento e validação
        try {
            //TODO: Corrigir parâmetro para teste
            cliente.setNome(nome);
            fail("Nome não pode conter números e símbolos");
        }catch (FilmeSemEstoqueException | ClienteException ex){
            assertThat(ex.getMessage(), equalTo("Números e símbolos não são permitidos"));
        }
    }
	
	@Test
    public void clienteNomeNaoDeveTerSimbolos() {
    	Cliente cliente = new Cliente();
        String nome = "Michel S@lomao";
        
           
    

        //Processamento e validação
        try {
            //TODO: Corrigir parâmetro para teste
            cliente.setNome(nome);
            fail("Nome não pode conter números e símbolos");
        }catch (FilmeSemEstoqueException | ClienteException ex){
            assertThat(ex.getMessage(), equalTo("Números e símbolos não são permitidos"));
        }
    }
}
