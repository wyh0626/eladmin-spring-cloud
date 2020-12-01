package com.claim.lis.wxregister.service;

import com.alibaba.nacos.client.utils.StringUtils;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Scanner;

/**
 * 类名称: Generator
 * 类描述: mybatisplus自动生成
 * 创建信息: 王银鹤/ 2020/11/2 17:29/ 1.0
 * 修改信息：王银鹤/ 2020/11/2 17:29/ 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CodeGenerator  {


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotBlank(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D://Table");
        gc.setFileOverride(false);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(false);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("wyh");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        //gc.setControllerName("%sController");
        //gc.setServiceName("I%sService");
        //gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sDao");
        gc.setXmlName("%sDao");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        //数据库驱动名
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        //账户
        dsc.setUsername("newclm");
        //密码
        dsc.setPassword("123456");
        //url
        dsc.setUrl("jdbc:mysql://172.18.100.35:3306/lis?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&rewriteBatchedStatements=true");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[] {""});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] { "ldsysvar"}); // 需要生成的表
        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.claim.lis.wxregister");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("impl");
        pc.setMapper("dao");
        pc.setEntity("vo");
        //pc.setXml("xml");
        mpg.setPackageInfo(pc);

       /* TemplateConfig templateConfig = new TemplateConfig()
                .setController("/model/entity2.java");

        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap(){//自定义参数
                Map<String, Object> map = new HashMap<>();
                map.put("modelName", "Test");
                this.setMap(map);
            }
        };

        mpg.setTemplate(templateConfig).setCfg(injectionConfig);*/
        // 执行生成
        mpg.execute();
    }
}
