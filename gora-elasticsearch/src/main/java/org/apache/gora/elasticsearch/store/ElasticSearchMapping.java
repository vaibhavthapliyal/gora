package org.apache.gora.elasticsearch.store;

import java.util.HashMap;

public class ElasticSearchMapping {
  private HashMap<String, String> document = new HashMap<>();
  private String indexname;
  private String type;
  private String schemaName;
  public String getIndexname() {
    return indexname;
  }

  public void setIndexname(String indexname) {
    this.indexname = indexname;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void addField(String goraField, String esField) {
    document.put(goraField, esField);
  }

  public String getSchemaName() {
    return schemaName;
  }

  public void setSchemaName(String schemaName) {
    this.schemaName = schemaName;
  }

  public HashMap<String, String> getDocument() {
    return document;
  }
  

}
