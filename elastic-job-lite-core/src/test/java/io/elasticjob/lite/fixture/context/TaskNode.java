/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.elasticjob.lite.fixture.context;

import com.google.common.base.Joiner;
import io.elasticjob.lite.context.ExecutionType;
import lombok.Builder;

@Builder
public final class TaskNode {
    
    private String jobName;
    
    private int shardingItem;
    
    private ExecutionType type;
    
    private String slaveId;
    
    private String uuid;
    
    /**
     * Get the path of task node.
     *
     * @return the path of task node
     */
    public String getTaskNodePath() {
        return Joiner.on("@-@").join(null == jobName ? "test_job" : jobName, shardingItem);
    }
    
    /**
     * Get the value of task node.
     *
     * @return the value of task node
     */
    public String getTaskNodeValue() {
        return Joiner.on("@-@").join(getTaskNodePath(), null == type ? ExecutionType.READY : type, null == slaveId ? "slave-S0" : slaveId, null == uuid ? "0" : uuid);
    }
}
