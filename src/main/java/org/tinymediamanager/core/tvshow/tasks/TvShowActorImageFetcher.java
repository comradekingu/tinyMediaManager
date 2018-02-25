/*
 * Copyright 2012 - 2018 Manuel Laggner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tinymediamanager.core.tvshow.tasks;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tinymediamanager.core.tasks.MediaEntityActorImageFetcher;
import org.tinymediamanager.core.tvshow.entities.TvShow;
import org.tinymediamanager.core.tvshow.entities.TvShowEpisode;

/**
 * The class TvShowActorImageFetcher.
 * 
 * @author Manuel Laggner
 */
public class TvShowActorImageFetcher extends MediaEntityActorImageFetcher {
  private final static Logger LOGGER = LoggerFactory.getLogger(TvShowActorImageFetcher.class);

  public TvShowActorImageFetcher(TvShow tvShow) {
    this.mediaEntity = tvShow;

    // create a set of all actors and guests
    persons = new HashSet<>(tvShow.getActors());
    for (TvShowEpisode episode : tvShow.getEpisodes()) {
      persons.addAll(episode.getGuests());
    }
  }

  @Override
  protected Logger getLogger() {
    return LOGGER;
  }
}
