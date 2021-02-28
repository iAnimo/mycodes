package mprojects2;
import java.util.HashMap;
import java.util.List;

import utils.VUnionSet;
import utils.mUser;

public class p017 {
    
    // a,b,c字段有一个相同则合并
    /*
     * 并查集 1. V={a,b,c...} 2. 并查集一开始认为每个样本都在单独的集合里 3. 有以下函数 boolean
     * isSameSet(x,y):查询样本x,y是否属于同一集合 void union(x,y):联合x,y为同一集合 4.
     * isSameSet和union方法的代价越低越好1
     */
    public int mergemUsers(List<mUser> users) {
        VUnionSet<mUser> unionSet = new VUnionSet<>(users);
        HashMap<String, mUser> mapA = new HashMap<>();
        HashMap<String, mUser> mapB = new HashMap<>();
        HashMap<String, mUser> mapC = new HashMap<>();

        for( mUser user : users ){
            if(mapA.containsKey(user.a)){
                unionSet.union(user, mapA.get(user.a));
            }else{
                mapA.put(user.a, user);
            }
            if(mapB.containsKey(user.b)){
                unionSet.union(user, mapB.get(user.b));
            }else{
                mapB.put(user.b, user);
            }
            if(mapC.containsKey(user.c)){
                unionSet.union(user, mapC.get(user.c));
            }else{
                mapC.put(user.c, user);
            }
        }
        return unionSet.getSetNum();
    }
}
