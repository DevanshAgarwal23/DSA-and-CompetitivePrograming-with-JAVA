package DisjointSet;

import java.util.*;

public class AccountMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> emailIdToIdMap = new HashMap<>();

        for(int i=0; i<accounts.size(); i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String currentMail = accounts.get(i).get(j);
                if(emailIdToIdMap.containsKey(currentMail)){
                    ds.union(i, emailIdToIdMap.get(currentMail));
                }else{
                    emailIdToIdMap.put(currentMail, i);
                }
            }
        }

        List<String>[] combinedMails = new ArrayList[n];
        for(int i=0;i<n;i++) combinedMails[i] = new ArrayList<>();

        for(Map.Entry<String,Integer> entry : emailIdToIdMap.entrySet()){
            String mail = entry.getKey();
            int id = ds.findParent(entry.getValue());

            combinedMails[id].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i =0; i<n;i++){
            if(combinedMails[i].size() == 0) continue;
            Collections.sort(combinedMails[i]);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String s : combinedMails[i]) temp.add(s);
            ans.add(temp);
        }

        return ans;
    }
}
