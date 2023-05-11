/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
public class MedicamentoDAO {

    private EntityManagerFactory conn;
    private EntityManager manager;

    public void conect() {
        conn = Persistence.createEntityManagerFactory("recPU");
        manager = conn.createEntityManager();
    }

    public int incluirMedicamento(Medicamento med) {
        conect();
        try {
            manager.getTransaction().begin();
            manager.persist(med);
            manager.getTransaction().commit();
            return 1;
        } catch (RollbackException ex) {
            return 2;
        } catch (Exception ex) {
            return 3;
        }
    }

    public List<Medicamento> listarMedicamentos() {
        conect();
        {
            try {
                TypedQuery<Medicamento> query = manager.createNamedQuery("Medicamento.findAll", Medicamento.class);
                List<Medicamento> medicamentos = query.getResultList();
                return medicamentos;
            } catch (NoResultException ex) {
                return null;
            }
        }
    }

    public Medicamento consultarMedicamento(int idMed) {
        conect();
        try {
            TypedQuery queryId = manager.createNamedQuery("Medicamento.findById", Medicamento.class);
            queryId.setParameter("id", idMed);
            Medicamento med = (Medicamento) queryId.getSingleResult();
            return med;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public int excluirMedicamento(int idMed) {
        conect();
        try {
            Medicamento med = manager.find(Medicamento.class, idMed);
            if (med == null) {
                return 2;
            } else {
                manager.getTransaction().begin();
                manager.remove(med);
                manager.getTransaction().commit();
                return 1; // Deu certo
            }
        } catch (Exception ex) {
            return 0; //Deu qualquer erro
        }
    }

    public int alterarMedicamento(int idMed, String nomeMed, String tipo, String comp, String pos, int dose, Double precoMed) {
        conect();
        try {
            Medicamento med = manager.find(Medicamento.class, idMed);
            med.setNome(nomeMed);
            med.setTipo(tipo);
            med.setComposicao(comp);
            med.setPosologia(pos);
            med.setDosagem(dose);
            med.setPreco(precoMed);
            manager.getTransaction().begin();
            manager.merge(med);
            manager.getTransaction().commit();
            return 1; // Deu certo
        } catch (Exception ex) {
            return 0; //Deu qualquer erro
        }
    }
    
        public Medicamento buscarMedicamento(int idMed) {
        conect();
        try {
            Medicamento med = manager.find(Medicamento.class, idMed);
            return med;
        } catch (Exception ex) {
            return null;
        }
    }

}
