// Agent bob in project transmitter
iteration(100).

/* Initial goals */
!start.

/* Plans */
+!start <-
    .print("hello world.");
    .difuser.port(ttyEmulatedPort0);
    !transmitt.

+!transmitt: iteration(I) & I > 0<-
    .random(R);
    .difuser.transmit(ramdom(I,R));
    -+iteration(I-1);
    .wait(1000*R);
    !transmitt.

-!transmitt <- .print("End of transmission").