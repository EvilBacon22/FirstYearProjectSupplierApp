package part01;

//below is me creating the enum for supRegion which is used along with the supplier constructor
public enum supRegion {
	UK {
		@Override
		String printSupRegionAsString() {
			return "UK";
		}
	},
	EU {
		@Override
		String printSupRegionAsString() {
			return "EU";
		}
	},
	OUTSIDE_EU {
		@Override
		String printSupRegionAsString() {
			return "Outside the EU";
		}
	};
	abstract String printSupRegionAsString();
}
