package platformbuilders.io.converter;

import org.junit.Before;
import org.junit.Test;

import platformbuilders.io.converter.mocks.MockCliente;
import platformbuilders.io.data.vo.v1.ClienteVO;

public class DozerConverterTest {
	
    MockCliente inputObject;

    @Before
    public void setUp() {
        inputObject = new MockCliente();
    }

    @Test
    public void parseEntityToVOTest() {
        ClienteVO output = DozerConverter.parseObject(inputObject.mockEntity(), ClienteVO.class);
//        Assert.assertEquals(Long.valueOf(0L), output.getKey());
//        Assert.assertEquals("CPF Test0", output.getCpf());
//        Assert.assertEquals("Nome Test0", output.getNome());
//        Assert.assertEquals("Data de nascimento Test0", output.getDataNascimento());
    }

}
