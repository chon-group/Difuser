package group.chon.agent.difuser.jasonStdLib;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import group.chon.agent.difuser.Difuser;

public class limit extends DefaultInternalAction {
    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {

        final Difuser argoArch = Difuser.getArgoArch(ts.getAgArch());
        if (argoArch != null) {
            if (args[0].isNumeric()) {
                argoArch.setLimit(Long.parseLong(args[0] + "000000"));
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