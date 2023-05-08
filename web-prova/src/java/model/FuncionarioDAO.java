/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

/**
 *
 * @author lucas.ssantos154
 */
public class FuncionarioDAO {

    private EntityManagerFactory conn;
    private EntityManager manager;

    public void conectar() {
        conn = Persistence.createEntityManagerFactory("web-provaPU");
        manager = conn.createEntityManager();

    }

    public int salvarFuncionario(Funcionario func) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(func);
            manager.getTransaction().commit();
            return 1;
        } catch (RollbackException ex) {
            return 2;
        } catch (Exception ex) {
            return 3;
        }
    }
public List<Funcionario> listarFuncionarios() {
        conectar();
        try {
            TypedQuery<Funcionario> query = manager.createNamedQuery("Funcionario.findAll", Funcionario.class);
            List<Funcionario> funcionarios = query.getResultList();
            return funcionarios;
        } catch (NoResultException ex) {
            return null;
        }
    }

public int excluirFuncionario(String matricula) {
        conectar();

        try {
            Funcionario func = manager.find(Funcionario.class, matricula);
            if (func == null) {
                return 2;
            } else {

                manager.getTransaction().begin();
                manager.remove(func);
                manager.getTransaction().commit();
                return 1; // Deu certo
            }
        } catch (Exception ex) {
            return 0; //Deu qualquer outro erro
        }

    }

    public int alterarFuncionario(String matricula, String nome, String cargo, int idade, double salario) {
        conectar();
        try {
            Funcionario func = manager.find(Funcionario.class, matricula);
            func.setMatricula(matricula);
            func.setNome(nome);
            func.setCargo(cargo);
            func.setIdade(idade);
            func.setSalario(salario);
            manager.getTransaction().begin();
            manager.merge(func);
            manager.getTransaction().commit();
            return 1; // Deu certo
        } catch (Exception ex) {
            return 0; //Deu qualquer erro
        }
    }

    public Funcionario buscarFuncionario (String matricula) {
        conectar();
        try {
            Funcionario func = manager.find(Funcionario.class, matricula);
            return func;
        } catch (Exception ex) {
            return null;
        }
    }
    
        public Funcionario consultarFuncionario(String matricula) {
        conectar();
        try {
            TypedQuery queryId = manager.createNamedQuery("Funcionario.findByMatricula", Funcionario.class);
            queryId.setParameter("matricula", matricula);
            Funcionario func = (Funcionario) queryId.getSingleResult();
            return func;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
