package cloud.caravana.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import cloud.caravana.algo.SimianAlgo;
import cloud.caravana.data.SimianData;


@ApplicationScoped
public class SimianService {
    @Inject
    EntityManager em;

    @Inject
    DataSource ds;

    public final Map<Boolean, Integer> getStats() {
        var sql = """
        select count(*) as count, simian 
        from simian_data 
        group by simian
        """;
        var stats = new HashMap<Boolean, Integer>();
        try(var conn = ds.getConnection();
            var stmt = conn.createStatement();){
            var rs = stmt.executeQuery(sql);
            while(rs.next()) {
                var count = rs.getInt("count");
                var simian = rs.getBoolean("simian");
                stats.put(simian, count);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stats;
    }

    public static final String hash(String dna){
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        byte[] encodedhash = digest.digest(dna.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Transactional
    public Boolean isSimian(String[] dna) {
        Boolean result = false;
        var dnaHash = hash(Arrays.toString(dna));
        var dnas = em.createNamedQuery("findDNA", SimianData.class)
            .setParameter("dnaHash", dnaHash)
            .setMaxResults(1)
            .getResultList();
        if (dnas.isEmpty()){
            var sd = new SimianData();
            sd.setDnaHash(dnaHash);
            result = SimianAlgo.isSimian(dna);
            sd.setSimian(result);
            em.persist(sd);
        }else{
            var sd = dnas.get(0);
            result = sd.isSimian();
        }
        return result;
    }

}
