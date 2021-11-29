/**
 * Copyright 2015 Knowm Inc. (http://knowm.org) and contributors.
 * Copyright 2013-2015 Xeiam LLC (http://xeiam.com) and contributors.
 * Copyright 2001-2011 Terracotta Inc. (http://terracotta.org).
 *
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
package org.quartz.listeners;

import org.quartz.core.JobExecutionContext;
import org.quartz.core.Scheduler;
import org.quartz.triggers.Trigger;
import org.quartz.triggers.Trigger.CompletedExecutionInstruction;

/**
 * The interface to be implemented by classes that want to be informed when a <code>{@link Trigger}</code> fires. In general, applications that use a
 * <code>Scheduler</code> will not have use for this mechanism.
 *
 * @author James House
 */
public interface TriggerListener {

  /*
   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Interface.
   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   */

  /**
   * <p>
   * Get the name of the <code>TriggerListener</code>.
   * </p>
   */
  String getName();

  /**
   * <p>
   * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code> has fired, and it's associated
   * <code>{@link org.quartz.jobs.JobDetail}</code> is about to be executed.
   * </p>
   * <p>
   * It is called before the <code>vetoJobExecution(..)</code> method of this interface.
   * </p>
   *
   * @param trigger The <code>Trigger</code> that has fired.
   * @param context The <code>JobExecutionContext</code> that will be passed to the <code>Job</code>'s<code>execute(xx)</code> method.
   */
  void triggerFired(Trigger trigger, JobExecutionContext context);

  /**
   * <p>
   * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code> has fired, and it's associated
   * <code>{@link org.quartz.jobs.JobDetail}</code> is about to be executed. If the implementation vetos the execution (via returning
   * <code>true</code>), the job's execute method will not be called.
   * </p>
   * <p>
   * It is called after the <code>triggerFired(..)</code> method of this interface.
   * </p>
   *
   * @param trigger The <code>Trigger</code> that has fired.
   * @param context The <code>JobExecutionContext</code> that will be passed to the <code>Job</code>'s<code>execute(xx)</code> method.
   */
  boolean vetoJobExecution(Trigger trigger, JobExecutionContext context);

  /**
   * <p>
   * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code> has misfired.
   * </p>
   * <p>
   * Consideration should be given to how much time is spent in this method, as it will affect all triggers that are misfiring. If you have lots of
   * triggers misfiring at once, it could be an issue it this method does a lot.
   * </p>
   *
   * @param trigger The <code>Trigger</code> that has misfired.
   */
  void triggerMisfired(Trigger trigger);

  /**
   * <p>
   * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code> has fired, it's associated
   * <code>{@link org.quartz.jobs.JobDetail}</code> has been executed, and it's <code>triggered(xx)</code> method has been called.
   * </p>
   *
   * @param trigger The <code>Trigger</code> that was fired.
   * @param context The <code>JobExecutionContext</code> that was passed to the <code>Job</code>'s<code>execute(xx)</code> method.
   * @param triggerInstructionCode the result of the call on the <code>Trigger</code>'s<code>triggered(xx)</code> method.
   */
  void triggerComplete(Trigger trigger, JobExecutionContext context, CompletedExecutionInstruction triggerInstructionCode);

}