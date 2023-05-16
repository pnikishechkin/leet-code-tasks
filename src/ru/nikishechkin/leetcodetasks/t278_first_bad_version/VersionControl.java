package ru.nikishechkin.leetcodetasks.t278_first_bad_version;

public class VersionControl {

    protected static int badVersion = 4;
    public static boolean isBadVersion(int version) {
        if (version >= badVersion) {
            return true;
        }
        return false;
    }
}
