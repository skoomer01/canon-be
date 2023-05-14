import codecrusaders.domain.Account;
import codecrusaders.domain.nestedstructure.Branch;
import codecrusaders.domain.nestedstructure.INestedComponent;
import codecrusaders.domain.nestedstructure.INestedStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MockGenerator {

    public static <P extends INestedStructure, C extends INestedComponent> List<P> assign(List<P> parents, List<C> children) {
        List<P> copyParents = new ArrayList<>(parents);
        List<C> childrenCopy = new ArrayList<>(children);
        for (P parent : copyParents) {
            for (C child : childrenCopy) {
                parent.add(child);
            }
        }
        return copyParents;
    }


    public static List<Branch> assignCreatedUser(List<Branch> branches, List<Account> accounts){
        List<Branch> branchList = new ArrayList<>(branches);
        List<Account> accountList = new ArrayList<>(accounts);
        for(int i = 0; i < branches.size(); i++){
            branchList.get(i).setCreatedUser(accountList.get(i));
        }
        return branchList;
    }

}
