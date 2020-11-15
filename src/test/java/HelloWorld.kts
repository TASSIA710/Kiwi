import net.tassia.kiwi.Server
import net.tassia.kiwi.route.StaticRoute

val srv = Server()
srv.router.GET("\\/hello", StaticRoute.fromString("Hello World!"))
srv.start()
