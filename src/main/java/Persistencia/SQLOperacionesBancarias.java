package Persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.OperacionesBancarias;

class SQLOperacionesBancarias {
     private final static String SQL = PersistenciaBancAndes.SQL;

     private PersistenciaBancAndes pp;

        public SQLOperacionesBancarias(PersistenciaBancAndes pp) {
            this.pp = pp;
        }


        public List <OperacionesBancarias> darOperacionesGerente (PersistenceManager pm){
            System.out.println("paso3__________________________________");
            Query q = pm.newQuery(SQL, "SELECT id, valor, fechaHora, numeroCuenta  FROM OPERACIONESBANCARIAS " + pp.darTablaOperacionesBancarias());
            q.setResultClass(OperacionesBancarias.class);
            System.out.println("Paso 4 ----------------------------------------------------------------------------");
             return (List<OperacionesBancarias>) q.executeList();
        }
	
        public List <OperacionesBancarias> darOperacionesCliente (PersistenceManager pm, BigDecimal numeroCuenta){
            System.out.println("paso3__________________________------");
            Query q = pm.newQuery(SQL, "SELECT id, valor, fechaHora, numeroCuenta  FROM OPERACIONESBANCARIAS " + pp.darTablaOperacionesBancarias() + " WHERE NUMEROCUENTA = ?");
            q.setResultClass(OperacionesBancarias.class);
            System.out.println("Paso 4 ----------------------------------------------------------------------------");
            q.setParameters(numeroCuenta);
            return (List<OperacionesBancarias>) q.executeList();
        }
	

}
