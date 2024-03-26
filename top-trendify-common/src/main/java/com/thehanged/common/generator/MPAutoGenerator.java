package com.thehanged.common.generator;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

public class MPAutoGenerator {
    /**
     * 策略配置
     */
    private static StrategyConfig strategyConfig() {
        return new StrategyConfig.Builder()
                .addTablePrefix("t_", "c_")
                // 实体配置
                .entityBuilder()
                .enableLombok()
                .fileOverride()
                // 数据持久层配置
                .mapperBuilder()
                .fileOverride()
                // 服务层配置
                .serviceBuilder()
                .fileOverride()
                // 控制层配置
                .controllerBuilder()
                .fileOverride()
                .build();
    }

    /**
     * 全局配置
     */
    private static GlobalConfig globalConfig() {
        return new GlobalConfig.Builder()
                .author("thehanged")
//                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .outputDir(System.getProperty("user.dir") + "/top-trendify-server/user-server" + "/src/main/java")
                .build();
    }

    /**
     * 包配置
     */
    private static PackageConfig packageConfig() {
        return new PackageConfig.Builder()
                .parent("com.thehanged.server.user")
                .entity("pojos")
                .controller("controller.v1")
//                .pathInfo() 生成了xml文件才需要配置输入目录
                .build();
    }

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://10.147.18.234:3306/top_trendify_user?serverTimezone=Asia/Shanghai", "root", "123456")
            .schema("mybatis-plus")
            .build();

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig());
        generator.global(globalConfig());
        generator.packageInfo(packageConfig());
        generator.execute();
    }
}
