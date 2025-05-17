/* Initial goals */
!start.

/* Plans */
+!start <-
    .print("hello world.");
    .difuser.port(ttyExogenous3);
    .difuser.limit(250);
    .difuser.listen(open).

+message(random(I,R)) <-
    .print("Message:", I," ",R);
    .difuser.transmit(ack(I)).


