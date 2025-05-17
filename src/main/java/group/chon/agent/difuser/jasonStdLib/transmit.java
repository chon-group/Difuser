package group.chon.agent.difuser.jasonStdLib;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import jason.asSyntax.Literal;
import group.chon.agent.difuser.Difuser;

public class transmit extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {

         final Difuser argoArch = Difuser.getArgoArch(ts.getAgArch());
            if (argoArch != null) {
                Term action = args[0];
                String message = "message("+action.toString()+")";
                if (argoArch.getJavino().sendCommand(argoArch.getPort(), message)) {
                    return true;
                } else {
                    String PORT = argoArch.getPort();
                    String PORTshortNAME=PORT.substring(PORT.lastIndexOf("/")+1);
                    if(PORTshortNAME==""){
                        PORTshortNAME="unknown";
                    }
                    ts.getAg().getBB().remove(Literal.parseLiteral("port("+PORTshortNAME+",on);"));
                    ts.getAg().getBB().add(Literal.parseLiteral("port("+PORTshortNAME+",off);"));
                    return false;
                }
            }else{
                ts.getLogger().warning(
                        "[WARNING] It was not possible to call internal action .act because this agent is not an Argo agent.");
                return false;
            }

    }
}