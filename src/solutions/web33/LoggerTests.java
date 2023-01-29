package solutions.web33;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;

class LoggerTests {
	private static final String NAME = "logger.log";
	private File file = new File(NAME);
	private Logger logger;
	Set<Level> set;

	@BeforeEach
	void setUp() throws Exception {
		file.delete();
	}

	@Test
	void testError() {
		runLogger(Level.ERROR);
		set = getLogsLevels();
		assertEquals(set, Set.of(Level.ERROR));
	}

	@Test
	void testWarn() {
		runLogger(Level.WARN);
		set = getLogsLevels();
		assertEquals(set, Set.of(Level.ERROR, Level.WARN));
	}

	@Test
	void testInfo() {
		runLogger(Level.INFO);
		set = getLogsLevels();
		assertEquals(set, Set.of(Level.ERROR, Level.WARN, Level.INFO));
	}

	@Test
	void testDebug() {
		runLogger(Level.DEBUG);
		set = getLogsLevels();
		assertEquals(set, Set.of(Level.ERROR, Level.WARN, Level.INFO, Level.DEBUG));
	}

	@Test
	void testTrace() {
		runLogger(Level.TRACE);
		set = getLogsLevels();
		assertEquals(set, Set.of(Level.ERROR, Level.WARN, Level.INFO, Level.DEBUG, Level.TRACE));
	}
	
	@Test
	void publishingToConsoleTest() {		
		logger = new Logger(new SimpleStreamHandler(System.out), "my_logger");
		logger.setLevel(Level.TRACE);
		runAllMethods();
	}
	
	private void runLogger(Level error) {
		try (PrintStream printStream = new PrintStream(NAME)) {
			logger = new Logger(new SimpleStreamHandler(printStream), "my_logger");
			logger.setLevel(error);
			runAllMethods();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Set<Level> getLogsLevels() {
		try (BufferedReader reader = new BufferedReader(new FileReader(NAME))) {			
			return reader.lines()
			.map(s->Level.valueOf(s.split(" ")[1]))
			.collect(Collectors.toSet());			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void runAllMethods() {
		logger.error("ERROR!!!");
		logger.warn("WARNING!!!");
		logger.info("INFO!!!");
		logger.debug("DEBUG!!!");
		logger.trace("TRACE!!!");		
	}

}