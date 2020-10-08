package net.tassia.kiwi;

import net.tassia.kiwi.views.HttpView;

@FunctionalInterface
public interface KiwiStatusPageBuilder {

	void buildStatusPage(HttpResponse response, HttpStatus status);

	KiwiStatusPageBuilder DEFAULT = (res, status) -> {
		HttpView view = status.getView();
		res.set(view.getData(), view.getContentType(), view.getCharset());
	};

}
