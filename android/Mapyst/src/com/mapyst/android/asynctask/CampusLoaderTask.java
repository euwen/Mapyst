/*
 * Copyright (C) 2013 Mapyst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mapyst.android.asynctask;

import com.mapyst.campus.Campus;

import android.os.AsyncTask;

public class CampusLoaderTask extends
		AsyncTask<CampusLoaderTaskPrefs, Integer, CampusLoaderTaskPrefs> {

	@Override
	protected void onPreExecute() { // This runs on the UI thread
		return;
	}

	@Override
	protected CampusLoaderTaskPrefs doInBackground(CampusLoaderTaskPrefs... prefs) { // This runs in the background
		for (CampusLoaderTaskPrefs pref : prefs) {
			pref.app.campus = Campus.load(pref.campus_id);
		}

		return prefs[0];
	}

	@Override
	protected void onProgressUpdate(Integer... progress) { // Called from background thread to UI thread
		return;
	}

	@Override
	protected void onPostExecute(CampusLoaderTaskPrefs result) { // Called UI thread
		result.loaderContext.finishedLoading();
		return;
	}

}