package com.seltzlab.mobile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.accounts.Account;
import android.accounts.AccountManager;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

public class AccountList extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {

		try {
			JSONObject obj = args.getJSONObject(0);

			AccountManager am = AccountManager.get(cordova.getActivity());

			Account[] accounts;
			if (obj.has("type"))
				accounts = am.getAccountsByType(obj.getString("type"));
			else
				accounts = am.getAccounts();

			JSONArray res = new JSONArray();
			for (int i = 0; i < accounts.length; i++) {
				Account a = accounts[i];
				// res.put(a.name);
				// res.put(a);
				JSONArray x = new JSONArray();
				x.put('name', a.name);
				x.put('type', a.type);
				res.put(x);
			}

			callbackContext.success(res);
			return true;

		} catch (JSONException e) {
			callbackContext.error(e);
			return false;
		}
	}

}
