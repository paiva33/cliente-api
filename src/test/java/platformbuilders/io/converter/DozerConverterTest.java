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

//    @Test
//    public void parseEntityListToVOListTest() {
//        List<ClienteVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), ClienteVO.class);
//        ClienteVO outputZero = outputList.get(0);
//        
//        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
//        Assert.assertEquals("Nome Test0", outputZero.getNome());
//        Assert.assertEquals("Cpf Test0", outputZero.getCpf());
//        Assert.assertEquals("Data de nascimento Test0", outputZero.getDataNascimento());
//        Assert.assertEquals("Idade Test0", outputZero.getIdade());
//        
//        ClienteVO outputSeven = outputList.get(7);
//        
//        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
//        Assert.assertEquals("Nome Test7", outputSeven.getNome());
//        Assert.assertEquals("CPF Test7", outputSeven.getCpf());
//        Assert.assertEquals("Data de nascimento Test7", outputSeven.getDataNascimento());
//        Assert.assertEquals("Idate Test0", outputSeven.getIdade());
//        
//        ClienteVO outputTwelve = outputList.get(12);
//        
//        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
//        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
//        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
//        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
//        Assert.assertEquals("Male", outputTwelve.getGender());
//    }

//    @Test
//    public void parseVOToEntityTest() {
//        Cliente output = DozerConverter.parseObject(inputObject.mockVO(), Cliente.class);
//        Assert.assertEquals(Long.valueOf(0L), output.getId());
//        Assert.assertEquals("First Name Test0", output.getFirstName());
//        Assert.assertEquals("Last Name Test0", output.getLastName());
//        Assert.assertEquals("Addres Test0", output.getAddress());
//        Assert.assertEquals("Male", output.getGender());
//    }
//
//    @Test
//    public void parserVOListToEntityListTest() {
//        List<Cliente> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Cliente.class);
//        Cliente outputZero = outputList.get(0);
//        
//        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
//        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
//        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
//        Assert.assertEquals("Addres Test0", outputZero.getAddress());
//        Assert.assertEquals("Male", outputZero.getGender());
//        
//        Cliente outputSeven = outputList.get(7);
//        
//        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
//        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
//        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
//        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
//        Assert.assertEquals("Female", outputSeven.getGender());
//        
//        Cliente outputTwelve = outputList.get(12);
//        
//        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
//        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
//        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
//        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
//        Assert.assertEquals("Male", outputTwelve.getGender());
//    }
}
