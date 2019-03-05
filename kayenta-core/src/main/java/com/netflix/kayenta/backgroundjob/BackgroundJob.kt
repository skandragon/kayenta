/*
 * Copyright 2019 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.kayenta.backgroundjob

import com.fasterxml.jackson.databind.ObjectMapper
import com.netflix.kayenta.metrics.MetricSet
import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool

val PENDING_TTL_MILLIS = 3600000L // 1 hour -- it should rarely be in this state long unless overloaded severely.
val RUNNING_TTL_MILLIS =  600000L
val FINAL_TTL_MILLIS   =  600000L

val mainPrefix = "jobQueue"

data class BackgroundJobState(val state: String,
                              val pipelineId: String,
                              val terminal: Boolean,
                              val message: String?,
                              val metricSet: MetricSet?)

abstract class BackgroundJob(prefix: String) : Runnable;

class BackgroundJobManager(val jedisPool: JedisPool,
                           val objectMapper: ObjectMapper) {

    fun queue(task: BackgroundJob) {
        // Create the key with the "enqueue timeout" TTL.
    }
}
