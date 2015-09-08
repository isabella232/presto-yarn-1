/*
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
 */

package com.teradata.presto.yarn.utils

import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

public class TimeUtils
{
  public static void retryUntil(Closure<Boolean> condition, long timeoutInMilliseconds)
  {
    long startTime = System.currentTimeMillis()

    while (System.currentTimeMillis() - startTime < timeoutInMilliseconds) {
      if (condition()) {
        return
      }

      Thread.sleep(TimeUnit.SECONDS.toMillis(2))
    }

    throw new TimeoutException('exceeded timeout')
  }
}
