package cloud.caravana.algo.simian;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "simian_data")
@NamedQueries({
    @NamedQuery(name = "findDNA", query = "SELECT sd FROM SimianData sd WHERE sd.dnaHash = :dnaHash")
})
public class SimianData {
  @Id
  String dnaHash;
  
  Boolean simian;
  
  public SimianData() {}

  public String getDnaHash() {
      return dnaHash;
  }

  public void setDnaHash(String dnaHash) {
      this.dnaHash = dnaHash;
  }

  public Boolean isSimian() {
      return simian;
  }

  public Boolean setSimian(Boolean simian) {
      return this.simian = simian;
  }
}
