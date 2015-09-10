package ru.agentlab.maia.memory.context.test.perf

import com.javamex.classmexer.MemoryUtil
import java.io.PrintWriter
import java.util.UUID
import org.junit.Test
import ru.agentlab.maia.memory.IMaiaContext
import ru.agentlab.maia.memory.doubles.DummyService

abstract class AbstractContextSetMemoryTests {

	@Test
	def void test() {
		val totalSize = 1_000
		val keys = newArrayOfSize(totalSize)
		val services = newArrayOfSize(totalSize)
		val results = newArrayOfSize(totalSize)

		for (i : 0 ..< totalSize) {
			val key = UUID.randomUUID.toString
			keys.set(i, key)
			val service = new DummyService
			services.set(i, service)
		}
		for (i : 0 ..< totalSize) {
			context.set(keys.get(i), services.get(i))
			results.set(i, MemoryUtil.deepMemoryUsageOf(context))
		}
//		}
		val writer = new PrintWriter('''«this.class.simpleName»_memory.csv''', "UTF-8")
		for (i : 0 ..< totalSize) {
			writer.println(results.get(i))
		}
		writer.close
	}

	def IMaiaContext getContext()

}