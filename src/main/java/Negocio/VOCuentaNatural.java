package Negocio;

import java.sql.Timestamp;

public interface VOCuentaNatural {

	public long getNumeroUnicoNatural();

    public long getNumeroEmpleador();

    public String getTipoCuenta();

    public int getSaldo();

    public String getEstado();

    public Timestamp getFechaCreacionCuenta();

    public Timestamp getFechaUltimoMovimiento();

    public int getValorAPagar();

    public String getFrecuenciaPago();

    public Timestamp getFechaAsocioacionCuenta();

    public long getNumeroIdCliente();
	
}
