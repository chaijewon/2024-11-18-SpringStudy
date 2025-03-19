package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *   XML / Annotation => Ŭ������ ��Ƽ� ����
 *   => Ŭ���� ��Ͻ� 
 *      -------- 1) ����� ������ �ִ� Ŭ���� (������Ʈ)
 *                                      | �����̳� (������)
 *                  DAO / Manager / Service / Model 
 *                  VO (DTO,Bean) => ����� �������� (X) 
 *      Ŭ���� ��� 
 *       <bean id="" class=""> : �޸� �Ҵ��Ŀ� ���� 
 *        => singleton : �Ѱ��� �޸𸮷� ����
 *        => ������ ���� : prototype => �����ؼ� ���ο� �޸� ���� 
 *           <bean id="" class="" scope="prototype">
 *                      => Object clone()
 *        => <bean id="" class=""> => �⺻ ����Ʈ ������ ȣ�� 
 *        => id�� Ŭ������ ã�� ���� ������ => �ݵ�� �ߺ����� ���� 
 *        => �����̳ʾȿ� ���� 
 *           ===== ���������� ���� 
 *                 BeanFactory : core(DI, ��ü ���� / ��ü �Ҹ�) 
 *                     |
 *               ApplicationContext : +AOP , ����ȭ
 *               ------------------- XML�� ��ϵ� ��� 
 *               AnnotationConfigApplicationContext 
 *               ---------------------------------- �ڹٷ� ���� (����)
 *                 | 5���� �̻󿡼� ���� ����
 *                     |
 *            WebApplicationContext : +MVC (WEB) => Controller
 *                                                  ----------
 *                                                  DispatcherServlet
 *                                                  | ó�� �޼ҵ� ã��
 *                                                    ------------
 *                                                    @RequestMapping
 *                                                     => GET/POST ����
 *                                                    @GetMapping
 *                                                    @PostMapping 
 *          Spring���� ���� (�Ի�� => ������) => Basic : �������� ���� ���� 
 *              �������� ��� 
 *            = DI => 70%
 *            = AOP => �ݺ� ���� (�������� Ŭ����)
 *            = ORM => �����ͺ��̽� ���� (MyBatis,JPA,Hibernate)
 *            = MVC 
 *            = Security 
 *            
 *          1) DI => ���� 
 *             -- IoC => DI
 *                --- ������ ���� (��ƾ�Ŀ﷯) => AI
 *                ���� => Ŭ������ Ŭ������ ���� ���踦 ���� (Ŭ���� ���̾�׷�)
 *                       => p:��ü��-ref="id��"
 *                       Ŭ������ �ʿ��� ������ ���� 
 *                       --------------------
 *                       => p:������="��"
 *                          -----------
 *                          setter / constructor
 *                          --------------------- XML������ ���� 
 *                          ������̼ǿ����� ����� �Ұ��� 
 *            Ŭ���� �Ѱ� �޸� �Ҵ� 
 *              <bean> 
 *            Ŭ���� �������� �ѹ��� �޸� �Ҵ� 
 *              <context:component-scan basepackage="">
 *              => �����ؼ� �޸� �Ҵ� ��û 
 *                       ------------- �޸𸮿� �Ҵ�� ��ü�� �������� ����
 *                 @Controller : Model Ŭ���� / ��ûó�� => Web 
 *                 @Component : �Ϲ� Ŭ���� => MainClass ..
 *                 @Repository : ����� => DAO
 *                 @Service : BI => ����  (DAO�� �������� �ѹ� ���սÿ� �ַ� ���)
 *                            EmpDAO / DeptDAO 
 *                            ---------------- ���� / ��������
 *                 @RestController : �ٸ� ���α׷� ���� 
 *                                   ---------- �ڹٽ�ũ��Ʈ (JSON) => WEB
 *                                              ---------------
 *                                              | VueJS
 *                 @ControllerAdvice : ���� ����ó�� 
 *                 @RestControllerAdvice : ���� ����ó�� 
 *                 @Bean : �ڹٷ� Ŭ���� ���� 
 *                  <bean>
 *                 ----------------------
 *                 
 *                 1. Ŭ������ �Ѱ��� ��� <bean> 
 *                    XML
 *                 2. ��� Ŭ������ �ѹ��� ��� : ��Ű�� ����
 *                    Annotation 
 *                 3. XML + Annotation : ���� ���
 *                          | ���� Ŭ���� (����� ���� Ŭ����)
 *                     | ���� ����Ǵ� Ŭ���� (���̺귯�� Ŭ����) => DAO / ����
 *            
 */
import com.sist.goods.*;
import com.sist.member.*;
import com.sist.sawon.*;
public class MainClass {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ����� XML�� �����̳ʷ� ���� 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		// Ŭ���� ã�� => Ȱ�� 
		SawonManager sa=(SawonManager)app.getBean("sa");
		sa.display();
		MemberManager mem=(MemberManager)app.getBean("mem");
		mem.display();
	}

}
