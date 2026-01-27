(ns clock)

(def MINS_DAY 1440)
(def MINS_HR 60)

(defn clock->string [clock]
  (let [h (quot clock MINS_HR)
        m (mod clock MINS_HR)]
    (format "%02d:%02d" h m)))

(defn clock [hours minutes]
  (let [mins-in-hr (* MINS_HR hours)]
    (mod (+ mins-in-hr minutes) MINS_DAY)))

(defn add-time [clock time]
  (mod (+ clock time) MINS_DAY))