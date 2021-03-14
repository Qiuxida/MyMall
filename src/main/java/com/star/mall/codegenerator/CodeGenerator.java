package com.star.mall.codegenerator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 代码生成器
 * @author StarQ
 * @since 2021-3-10
 */
public class CodeGenerator {

    private final static String AUTHOR = "StarQ";

    private final static String URL = "jdbc:mysql://8.135.0.233:3306/mall?characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Abc123";

    private final static String PACKAGE = "mall";
    private final static String PARENT = "com.star";
    private final static String TABLE = "mall_goods";
    private final static String SUPER_CONTROLLER = "com.star.mall.base.BaseController";
    private final static String SUPER_MODEL = "com.star.mall.base.model.BaseModel";
    private final static String TABLE_PREFIX = "mall_";

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        // 实体属性 Swagger2 注解
//        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(PACKAGE);
        pc.setParent(PARENT);
        pc.setService("persistence.service");
        pc.setServiceImpl("persistence.service.impl");
        pc.setEntity("persistence.entity");
        pc.setMapper("persistence.mapper");
        pc.setXml(".xml");
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
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setSuperEntityClass(SUPER_MODEL);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass(SUPER_CONTROLLER);
        strategy.setInclude(TABLE);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(TABLE_PREFIX);
        strategy.setLogicDeleteFieldName("deleted");

        strategy.setSuperEntityColumns("create_by_","create_time","update_by_","update_time_", "deleted_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
