package zc.com.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.shardingsphere.underlying.common.config.properties.ConfigurationPropertyKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author yeyu
 * @since 2022/7/8 13:57
 */
@Configuration
public class ShardingJdbcConfig {
    // sharding‐Jdbc 数据源
    @Bean
    public DataSource getShardingDataSource() throws SQLException {
        // 定义数据源，此处我们定义数据源名称为 m2
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://daily-mysql.webuyops.com:3306/test?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT%2B8");
        dataSource.setUsername("social");
        dataSource.setPassword("_DRTMie0L");
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("m2", dataSource);
        // 分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        // 其他配置
        Properties properties = new Properties();
        properties.put(ConfigurationPropertyKey.SQL_SHOW.getKey(), "true");
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, properties);
    }

    // 分片规则
    private TableRuleConfiguration getOrderTableRuleConfiguration() {
        // 指定 t_order 表的数据分布情况，配置数据节点
        TableRuleConfiguration result = new TableRuleConfiguration("t_order", "m2.t_order_$->{1..2}");
        // 指定 t_order 表的分片策略，分片策略包括分片键和分片算法
        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_$->{order_id%2+1}"));
        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        return result;
    }

    // 定义主键生成策略
    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() {
        return new KeyGeneratorConfiguration("SNOWFLAKE", "order_id");
    }
}
