import Mapper.UserMapper;
import com.*;
import com.scan.BeanScan;
import com.scan.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan("com")
@BeanScan("Mapper")
@Import({RegistrarBeanDefinition.class,TextImport.class})

public class Config {



    public static void main(String[] args) throws ClassNotFoundException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Bean01 bean01 = applicationContext.getBean("bean01", Bean01.class);
      //  UserMapper up = applicationContext.getBean("userMapperFactoryBean", UserMapper.class);
        Bean01 user = applicationContext.getBean("bean01", Bean01.class);
        user.text();
        System.out.println("========================");
        //TextImport text = applicationContext.getBean("textImport", TextImport.class);


        //测试是否可以完成路径的扫描




    }
}
