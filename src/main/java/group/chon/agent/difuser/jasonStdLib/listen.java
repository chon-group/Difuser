package group.chon.agent.difuser.jasonStdLib;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import group.chon.agent.difuser.Difuser;

public class listen extends DefaultInternalAction {
    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        final Difuser argoArch = Difuser.getArgoArch(ts.getAgArch());
        if (argoArch != null) {
            if (args[0].toString().equals("block") || args[0].toString().equals("close") ) {
                argoArch.setBlocked(true);
                return true;
            }else if (args[0].toString().equals("open")) {
                argoArch.setBlocked(false);
                return true;
            } else {
                return false;
            }
        }else{
             ts.getLogger().warning("[WARNING] It was not possible to call internal action .act because this agent is not an Argo agent.");
            return false;
        }
        
    }
}