package com.objogate.wl.gesture;

import java.awt.Point;
import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;
import com.objogate.wl.ComponentSelector;
import com.objogate.wl.Prober;

public class ComponentCenterTracker implements Tracker, SelfDescribing {
    private final Prober prober;
    private final ComponentScreenBoundsProbe probe;

    public ComponentCenterTracker(Prober prober, ComponentSelector componentSelector) {
        this.prober = prober;
        this.probe = new ComponentScreenBoundsProbe(componentSelector);
    }

    public Point target(Point currentLocation) {
        prober.check("moving to component", probe);

        return new Point((int) probe.bounds.getCenterX(), (int) probe.bounds.getCenterY());
    }

    public void describeTo(Description description) {
        description.appendText("center of ");
        description.appendDescriptionOf(probe);
    }
}
