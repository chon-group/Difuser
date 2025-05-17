// Agent bob in project transmitter
iteration(100).

/* Initial goals */
!start.

/* Plans */
+!start <-
    .print("hello world.");
    .difuser.port(ttyEmulatedPort3);
    .difuser.listen(open);
    .difuser.limit(250);
    !transmitt.

+!transmitt: iteration(I) & I > 0<-
    .random(R);
    .difuser.transmit(random(I,R)).
-!transmitt <- .print("End of transmission"); .stopMAS.

+message(ack(I)) <- 
    -+iteration(I-1); 
    .print("Ack ",I);
 //   .random(R); .wait(100*R);
    !transmitt.