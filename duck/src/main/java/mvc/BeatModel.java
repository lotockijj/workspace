package mvc;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;

import com.sun.media.jfxmedia.track.Track;

public class BeatModel implements BeatModelInterface, MetaEventListener {

	Sequence sequencer;
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	int bpm = 90;
	// other instance variables here
	Sequence sequence;
	javax.sound.midi.Track track;
	private MetaMessage message;

	public void meta(MetaMessage meta) {
		if (message.getType() == 47) {
			beatEvent();
			((Sequencer) sequencer).start();
			setBPM(getBPM());
		}

	}

	public void initialize() {
		setUpMidi();
		buildTrackAndStart();
	}

	public void on() {
		((Sequencer) sequencer).start();
		setBPM(90);
	}

	public void off() {
		setBPM(0);
		((Sequencer) sequencer).stop();
	}

	public void setBPM(int bpm) {
		this.bpm = bpm;
		((Sequencer) sequencer).setTempoInBPM(getBPM());
		notifyBPMObservers();
	}

	public int getBPM() {
		return bpm;
	}

	void beatEvent() {
		notifyBeatObservers();
	}

	// Code to register and notify observers
	// Lots of MIDI code to handle the beat

	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}

	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}

	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}

	public void setUpMidi() {
		try {
			sequencer = (Sequence) MidiSystem.getSequencer();
			((MidiDevice) sequencer).open();
			((Sequencer) sequencer).addMetaEventListener(this);
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			((Sequencer) sequencer).setTempoInBPM(getBPM());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void buildTrackAndStart() {
		int[] trackList = {35, 0, 46, 0};
		sequence.deleteTrack(null);
		track = sequence.createTrack();
		makeTracks(trackList);
		((List) track).add(makeEvent(192,9,1,0,4));
		try {
			((Sequencer) sequencer).setSequence(sequence);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void makeTracks(int[] list) {
		for (int i = 0; i < list.length; i++) {
			int key = list[i];
			if (key != 0) {
				((List) track).add(makeEvent(144,9,key, 100, i));
				((List) track).add(makeEvent(128,9,key, 100, i+1));
			}
		}
	}
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return event;
	}
}
