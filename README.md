akka-lost-http-context-2_1-rc2
==============================

A sample app demonstrating the problem that in play-2.1-rc2 Http.Context.current() is not accessible in an Akka actor.

Usage
====

Simply run the app then access [http://localhost:9000](http://localhost:9000), the following lines are the output from console indicating that Http.Context.current() is accessible in an Action but is not accessible in an Akka actor.

```
[debug] application - AccessHttpContextAction.call
[debug] application -   Setting current user to context as Foo
[debug] application -   Fetch current user from Http.Context.current()
[debug] application -   current user: Foo
[debug] application - Application.index
[info] play - Starting application default Akka system.
[debug] application - AccessHttpContextActor.onReceive
[debug] application -   Try to access Context.curent()
[ERROR] [01/22/2013 18:05:13.047] [application-akka.actor.default-dispatcher-5] [akka://application/user/$a] There is no HTTP Context available from here.
java.lang.RuntimeException: There is no HTTP Context available from here.
    at play.mvc.Http$Context.current(Http.java:30)
    at akka.AccessHttpContextActor.onReceive(AccessHttpContextActor.java:16)
    at akka.actor.UntypedActor$$anonfun$receive$1.applyOrElse(UntypedActor.scala:159)
    at akka.actor.ActorCell.receiveMessage(ActorCell.scala:425)
    at akka.actor.ActorCell.invoke(ActorCell.scala:386)
    at akka.dispatch.Mailbox.processMailbox(Mailbox.scala:230)
    at akka.dispatch.Mailbox.run(Mailbox.scala:212)
    at akka.dispatch.ForkJoinExecutorConfigurator$MailboxExecutionTask.exec(AbstractDispatcher.scala:502)
    at scala.concurrent.forkjoin.ForkJoinTask.doExec(ForkJoinTask.java:262)
    at scala.concurrent.forkjoin.ForkJoinPool$WorkQueue.runTask(ForkJoinPool.java:975)
    at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1478)
    at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:104)
```
