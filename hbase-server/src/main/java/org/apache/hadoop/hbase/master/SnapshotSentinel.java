/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.master;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.hbase.errorhandling.ForeignException;
import org.apache.hadoop.hbase.protobuf.generated.HBaseProtos.SnapshotDescription;

/**
 * Watch the current snapshot under process
 */
@InterfaceAudience.Private
@InterfaceStability.Unstable
public interface SnapshotSentinel {

  /**
   * Check to see if the snapshot is finished, where finished may be success or failure.
   * @return <tt>false</tt> if the snapshot is still in progress, <tt>true</tt> if the snapshot has
   *         finished
   */
  public boolean isFinished();

  /**
   * Actively cancel a running snapshot.
   * @param why Reason for cancellation.
   */
  public void cancel(String why);

  /**
   * @return the description of the snapshot being run
   */
  public SnapshotDescription getSnapshot();

  /**
   * Get the exception that caused the snapshot to fail, if the snapshot has failed.
   * @return {@link ForeignException} that caused the snapshot to fail, or <tt>null</tt> if the
   *  snapshot is still in progress or has succeeded
   */
  public ForeignException getExceptionIfFailed();

}
