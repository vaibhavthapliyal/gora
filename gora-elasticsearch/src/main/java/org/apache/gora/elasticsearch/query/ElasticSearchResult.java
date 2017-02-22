package org.apache.gora.elasticsearch.query;

import java.io.IOException;

import org.apache.gora.persistency.impl.PersistentBase;
import org.apache.gora.query.Query;
import org.apache.gora.query.impl.ResultBase;
import org.apache.gora.store.DataStore;

public class ElasticSearchResult<K,T extends PersistentBase> extends ResultBase<K,T> {

  public ElasticSearchResult(DataStore<K, T> dataStore, Query<K, T> query) {
    super(dataStore, query);
    // TODO Auto-generated constructor stub
  }

  @Override
  public float getProgress() throws IOException, InterruptedException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  protected boolean nextInner() throws IOException {
    // TODO Auto-generated method stub
    return false;
  }

}
