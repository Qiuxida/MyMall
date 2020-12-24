package com.star.mall.codegenerator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {

    private final static String AUTHOR = "邱喜达";

    private final static String URL = "jdbc:mysql://localhost:3306/mall?characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private final static String PACKAGE = "persistence1";
    private final static String PARENT = "com.star.mall";
    private final static String TABLE = "uc_user";
    private final static String SUPER_CONTROLLER = "com.star.mall.base.BaseController";

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(PACKAGE);
        pc.setParent(PARENT);
        mpg.setPackageInfo(pc);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        templateConfig.setEntity("templates/entity.java");
//        templateConfig.setService("templates/service.java");
//        templateConfig.setServiceImpl("templates/serviceImpl.java");
//        templateConfig.setController("templates/controller.java");
//        templateConfig.setXml("templates/mapper.xml");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass(SUPER_CONTROLLER);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(TABLE);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("uc_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
