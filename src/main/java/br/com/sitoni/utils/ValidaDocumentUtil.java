package br.com.sitoni.utils;

public class ValidaDocumentUtil {

    //private static final String NUMERO_INVALIDO = "Não é um número válido";

    private ValidaDocumentUtil() {
    }
	
	public static boolean isValidCPF(String vrCPF) {
        String valor = vrCPF.replace(".", "");
        valor = valor.replace("-", "");
        
        if (valor.length() != 11)
            return false;

        if (isEquals(valor))
        	return false;

        if (valor.equals("12345678909"))
            return false;

        int[] numeros = getNumeros(valor);
        
        int soma = 0;
        for (int i = 0; i < 9; i++)
            soma += (10 - i) * numeros[i];
       
        int resultado = soma % 11;
        if (resultado == 1 || resultado == 0) {
            if (numeros[9] != 0)
                return false;
        } else if (numeros[9] != 11 - resultado)
            return false;

        soma = 0;
        for (int i = 0; i < 10; i++)
            soma += (11 - i) * numeros[i];

        resultado = soma % 11;

        if (resultado == 1 || resultado == 0) {
            if (numeros[10] != 0)
                return false;

        } else if (numeros[10] != 11 - resultado)
                return false;
        
        return true;
    }

	private static boolean isEquals(String valor) {
		for (int i = 1; i < 11; i++)
            if (valor.charAt(i) != valor.charAt(0))
                return false;
		
		return true;
	}
	
	private static int[] getNumeros(String valor) {
		int[] numeros = new int[11];
        for (int i = 0; i < 11; i++)
            numeros[i] = Integer.parseInt(String.valueOf(valor.charAt(i)));
        
        return numeros;
	}
	
	  
}