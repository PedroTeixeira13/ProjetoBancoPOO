package pessoas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import contas.Conta;

public class Gerente extends Funcionario {
	
		public Gerente() {
		super();
	}
	
	public Gerente(String nome, String cpf, String cargo, String senha) {
		super(nome, cpf, cargo, senha);
	}
}