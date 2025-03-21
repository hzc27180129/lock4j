/*
 *  Copyright (c) 2018-2022, baomidou (63976799@qq.com).
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.baomidou.lock.spring.boot.autoconfigure;

import com.baomidou.lock.executor.EtcdLockExecutor;
import io.etcd.jetcd.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Redisson锁自动配置器
 *
 * @author zengzhihong
 */
@Configuration
//@ConditionalOnClass(Redisson.class)
class EtcdLockAutoConfiguration {
    @Bean
    @Order(400)
    public EtcdLockExecutor redissonLockExecutor() {
        return new EtcdLockExecutor(Client.builder().endpoints("http://localhost:2379").build());
    }

}