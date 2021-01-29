package platformbuilders.io.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import platformbuilders.io.data.model.Cliente;
import platformbuilders.io.data.vo.v1.ClienteVO;

public class MockCliente {


    public Cliente mockEntity() {
    	return mockEntity(0);
    }
    
    public ClienteVO mockVO() {
    	return mockVO(0);
    }
    
    public List<Cliente> mockEntityList() {
        List<Cliente> Clientes = new ArrayList<Cliente>();
        for (int i = 0; i < 14; i++) {
            Clientes.add(mockEntity(i));
        }
        return Clientes;
    }

    public List<ClienteVO> mockVOList() {
        List<ClienteVO> Clientes = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Clientes.add(mockVO(i));
        }
        return Clientes;
    }
    
    private Cliente mockEntity(Integer number) {
    	Cliente Cliente = new Cliente();
        return Cliente;
    }

    private ClienteVO mockVO(Integer number) {
    	ClienteVO Cliente = new ClienteVO();
        return Cliente;
    }

}
