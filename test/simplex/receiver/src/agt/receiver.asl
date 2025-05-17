/* Initial goals */
!start.

/* Plans */
+!start <-
    .print("hello world.");
    .difuser.port(ttyExogenous0);
    .difuser.listen(open).

+message(M) <- .print("new message received: ",M).
